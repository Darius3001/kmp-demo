import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.viewmodel.ViewModel

@Composable
fun App() {

    val viewModel = MainViewModel.getInstance()

    val recreationUnsafeNum = mutableStateOf(0)

    MaterialTheme {
        var volatileNum by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    viewModel.inc()
                }
            ) {
                Text("in ViewModel: ${viewModel.state.value}")
            }

            Button(
                onClick = {
                    recreationUnsafeNum.value++
                }
            ) {
                Text("Recreation unsafe: ${recreationUnsafeNum.value}")
            }

            Button(
                onClick = {
                    volatileNum++
                }
            ) {
                Text("Volatile: $volatileNum")
            }
        }
    }
}

class MainViewModel : ViewModel() {

    var state: MutableState<Int> = mutableStateOf(0)

    fun inc() {
        state.value += 1
    }

    companion object {
        private var instance: MainViewModel? = null

        fun getInstance(): MainViewModel {

            if (instance != null) return instance as MainViewModel

            return MainViewModel().apply { instance = this }
        }
    }
}
