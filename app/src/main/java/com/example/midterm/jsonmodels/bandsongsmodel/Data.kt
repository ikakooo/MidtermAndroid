package com.example.midterm.jsonmodels.bandsongsmodel

import com.example.midterm.jsonmodels.bandsongsmodel.Song

data class Data(
    val band: String,
    val songs: List<Song>
)