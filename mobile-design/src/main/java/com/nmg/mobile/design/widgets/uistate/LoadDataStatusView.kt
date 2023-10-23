package com.nmg.mobile.design.widgets.uistate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

enum class LoadDataStatus {
    SUCCESS, LOADING, EMPTY, ERROR
}

data class LoadDataStatusModel(
    val loadDataStatus: LoadDataStatus,
    val hasMore: Boolean = false,
    val message: String? = null,
) {
    val loading: Boolean = loadDataStatus == LoadDataStatus.LOADING
    val error: Boolean = loadDataStatus == LoadDataStatus.ERROR
    val empty: Boolean = loadDataStatus == LoadDataStatus.EMPTY
    val successful: Boolean = loadDataStatus == LoadDataStatus.SUCCESS
}

@Composable
fun LoadDataStatusView(
    loadDataStatusModel: LoadDataStatusModel,
    successView: @Composable ((BoxScope, LoadDataStatusModel) -> Unit)? = null,
    loadingView: @Composable ((BoxScope, LoadDataStatusModel) -> Unit)? = { boxScope, loadingStatusData ->
        DefaultLoadingView(boxScope, loadingStatusData)
    },
    errorView: @Composable ((BoxScope, LoadDataStatusModel) -> Unit)? = { boxScope, loadingStatusData ->
        DefaultErrorView(boxScope, loadingStatusData)
    },
    emptyView: @Composable ((BoxScope, LoadDataStatusModel) -> Unit)? = { boxScope, loadingStatusData ->
        DefaultEmptyView(boxScope, loadingStatusData)
    },
) {
    when (loadDataStatusModel.loadDataStatus) {
        LoadDataStatus.SUCCESS -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                successView?.also {
                    it(this, loadDataStatusModel)
                }
            }
        }

        LoadDataStatus.LOADING -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                loadingView?.also {
                    it(this, loadDataStatusModel)
                }
            }
        }

        LoadDataStatus.ERROR -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                errorView?.also {
                    it(this, loadDataStatusModel)
                }
            }
        }

        LoadDataStatus.EMPTY -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                emptyView?.also {
                    it(this, loadDataStatusModel)
                }
            }
        }
    }
}

@Composable
fun DefaultLoadingView(boxScope: BoxScope, loadDataStatusModel: LoadDataStatusModel) {
    boxScope.apply {
        CircularProgressIndicator(
            color = NMGTheme.colors.primaryMain,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(NMGTheme.customSystem.padding)
                .size(32.dp)
        )
    }
}

@Composable
fun DefaultEmptyView(boxScope: BoxScope, loadDataStatusModel: LoadDataStatusModel) {
    boxScope.apply {
        loadDataStatusModel.message?.also {
            boxScope.apply {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(NMGTheme.customSystem.padding),
                    text = it,
                    style = NMGTheme.typography.eleRegular14,
                    color = NMGTheme.colors.commonNeutralGray80
                )
            }
        }
    }
}

@Composable
fun DefaultErrorView(boxScope: BoxScope, loadDataStatusModel: LoadDataStatusModel) {
    boxScope.apply {
        loadDataStatusModel.message?.also {
            boxScope.apply {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(NMGTheme.customSystem.padding),
                    text = it,
                    style = NMGTheme.typography.eleRegular14,
                    color = NMGTheme.colors.commonNeutralGray80
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultLoadingStatusView_Preview() {
    NMGTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
            ) {
                LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.LOADING))
            }

            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
            ) {
                LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.ERROR, message = "error"))
            }

            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
            ) {
                LoadDataStatusView(LoadDataStatusModel(LoadDataStatus.ERROR, message = "no data"))
            }
        }
    }
}
