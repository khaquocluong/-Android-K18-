package com.example.android2022_1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student (val email: String, val password: String): Parcelable {
}