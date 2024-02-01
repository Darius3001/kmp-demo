import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

actual fun getPlatformName(): String = "Android"

val recreatorFlow = MutableSharedFlow<Unit>()

@Composable fun MainView() {
    val scope = rememberCoroutineScope()
    Column {

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
