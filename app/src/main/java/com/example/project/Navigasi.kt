package com.example.project

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.model.ListGender
import com.example.project.ui.view.DetailMahasiswaView
import com.example.project.ui.view.FormMahasiswaView
import com.example.project.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { ispadding ->
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(ispadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ){
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listGender = ListGender.listGender.map {
                        isi -> konteks.resources.getString(isi)
                    },
                    onSubmitClick ={
                        viewModel.saveDataMhs(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name) {
                DetailMahasiswaView(
                    dataMhs = uiState,
                    onClickButton = {
                        navHost.popBackStack()
                    }
                )
            }
        }
    }
}