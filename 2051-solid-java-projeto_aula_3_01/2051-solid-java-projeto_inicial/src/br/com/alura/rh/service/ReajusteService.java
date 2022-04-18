import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

    public ReajusteService (List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    private List<ValidacaoReajuste> validacoes;
    
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
    }
}
