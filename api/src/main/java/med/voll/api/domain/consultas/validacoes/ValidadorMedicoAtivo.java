package med.voll.api.domain.consultas.validacoes;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoExecption;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    private final MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoExecption("Consulta não pode ser agendada com o médico excluido");
        }
    }
}
