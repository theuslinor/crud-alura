package med.voll.api.domain.consultas.validacoes;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoExecption;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas{

    private final MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoExecption("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
