package br.edu.utfpr.trabalhofinal.ui.utils.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbDownOffAlt
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import br.edu.utfpr.trabalhofinal.R
import br.edu.utfpr.trabalhofinal.data.TipoContaEnum

@Composable
fun PaidIconButton(
    modifier: Modifier = Modifier,
    isPaid: Boolean,
    isCost: TipoContaEnum,
    onPressed: () -> Unit) {
        IconButton(
            modifier = modifier,
            onClick = onPressed
        ){
            Icon(
                imageVector = if (isPaid){
                    Icons.Filled.ThumbUp
                } else {
                    Icons.Filled.ThumbDownOffAlt
                },

                contentDescription = stringResource(R.string.est_pago),
                tint = if (isPaid){
                    if (isCost==TipoContaEnum.DESPESA) {
                        Color(0xFFCF5355)
                    } else{
                        Color(0xFF00984E)
                    }
                } else{
                    if (isCost==TipoContaEnum.DESPESA) {
                        Color(0xFFCF5355)
                    } else{
                        Color(0xFF00984E)
                    }
                }
            )

        }

}