import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

val recreatorFlow = MutableSharedFlow<Unit>()

@Composable fun MainView() {
    val scope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        App()

        Button(
            onClick = {
                scope.launch {
                    recreatorFlow.emit(Unit)
                }
            }
        ) {
            Text("recreate")
        }
    }
}
