package br.edu.utfpr.trabalhofinal.ui.conta.form
import br.edu.utfpr.trabalhofinal.data.Conta
import br.edu.utfpr.trabalhofinal.data.TipoContaEnum
import java.time.LocalDate

data class FormField<T>(
    val valor: T,
    val codigoMensagemErro: Int = 0
) {
    private val contemErro get(): Boolean = codigoMensagemErro > 0
    val valido get(): Boolean = !contemErro
}
data class FormularioContaState(
    val idConta: Int = 0,
    val carregando: Boolean = false,
    val conta: Conta = Conta(),
    val erroAoCarregar: Boolean = false,
    val salvando: Boolean = false,
    val mostrarDialogConfirmacao: Boolean = false,
    val excluindo: Boolean = false,
    val contaPersistidaOuRemovida: Boolean = false,
    val codigoMensagem: Int = 0,
    val descricao: FormField<String> = FormField(valor = ""),
    val data: FormField<LocalDate> = FormField(valor = LocalDate.now()),
    val valor: FormField<String> = FormField(valor = ""),
    val paga: FormField<Boolean> = FormField(valor = false),
    val tipo: FormField<TipoContaEnum> = FormField(valor = TipoContaEnum.DESPESA),
    val readOnly: Boolean = false
) {
    val contaNova get(): Boolean = idConta <= 0
    val formularioValido get(): Boolean = descricao.valido &&
            data.valido &&
            valor.valido &&
            paga.valido &&
            tipo.valido
}