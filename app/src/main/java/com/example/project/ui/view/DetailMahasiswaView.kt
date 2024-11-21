package com.example.project.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project.model.Mahasiswa

@Composable
fun DetailMahasiswaView(
    dataMhs:Mahasiswa,
    modifier: Modifier= Modifier
){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Gender", dataMhs.gender),
        Pair("Alamat", dataMhs.alamat),
    )

    Column (
        modifier= modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        listDataMhs.forEach { data ->
            DetailMhs(judul = data.first,
                isi = data.second)
        }
    }
}

@Composable
fun DetailMhs(
    judul:String, isi:String
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isi,
                modifier = Modifier.weight(2f))
        }
    }
}