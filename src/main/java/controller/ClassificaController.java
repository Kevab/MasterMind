package controller;

import DTO.UserDTO;
import com.mysql.cj.xdevapi.Collection;
import model.CombinationModel;
import model.CombinationRepository;
import model.TryModel;
import model.TryRepository;
import services.MasterMindComparator;
import services.ServiceCombination;
import services.ServiceTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClassificaController {

    private ServiceCombination combServ;
    private ServiceTry tryServ;
    private CombinationRepository combinationRepository;
    private TryRepository tryRepository;


    public ClassificaController(ServiceCombination combServ, ServiceTry tryServ) {
        this.combServ = combServ;
        this.tryServ = tryServ;
    }

    //METODO CLASSIFICA richiama CombinationService
    public ArrayList<UserDTO> getUserClassifica() {

        ArrayList<CombinationModel> modelliCombinazione = combinationRepository.findAllCombinationComb();
        ArrayList<TryModel> modelliTentativi = tryRepository.findAllCombinationTry();

        ArrayList<UserDTO> risultatoFinaleBellissimo = new ArrayList<>();


        for (CombinationModel m : modelliCombinazione) {
            UserDTO dto = new UserDTO();

            dto.setidUtente(m.getId());
            dto.setUtente(m.getNome());
            dto.setPunteggio(this.calcolaPunteggio(modelliTentativi, dto.getIdUtente()));

            risultatoFinaleBellissimo.add(dto);
            Collections.sort(risultatoFinaleBellissimo, new MasterMindComparator<UserDTO>());
        }
        return risultatoFinaleBellissimo;
    }

    public double calcolaPunteggio(ArrayList<TryModel> tentativi, int id) {
        int tentGiusti = 0;
        int tentTotali = 0;

        for (TryModel tryM : tentativi) {

            if (tryM.getFk_id() == id) {
                tentTotali += 1;

                if (tryM.getNum_pos() == 3)
                    tentGiusti += 1;
            }
        }
        return (tentGiusti * 100) / tentTotali;
    }
}
