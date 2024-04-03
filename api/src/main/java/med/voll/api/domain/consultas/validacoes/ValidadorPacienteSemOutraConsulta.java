package med.voll.api.domain.consultas.validacoes;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoExecption;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorPacienteSemOutraConsulta implements ValidadorAgendamentoDeConsultas{

    private final ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoExecption("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
