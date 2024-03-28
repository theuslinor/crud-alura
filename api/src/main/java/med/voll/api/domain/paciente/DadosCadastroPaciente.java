package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(

        @NotBlank(message = "Nome é obrigatório.")
        String nome,
        @NotBlank(message = "Email é obrigatório.")
        @Email(message = "Formato de Email invalido.")
        String email,
        @CPF(message = "CPF é obrigatório.")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "Formato do CPF inválido.")
        String cpf,
        @NotBlank(message = "Telefone é obrigatório.")
        String telefone,
        @NotNull(message = "Dados do endereço são obrigatório.")
        @Valid
        DadosEndereco endereco) {


}
