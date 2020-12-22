package com.ahmadraihan.sqlite1

import android.provider.BaseColumns

object DBInfo {
    class UserInput: BaseColumns {
        companion object {
            val TABLE_INI = "coba"
            val COL_EMAIL = "email"
            val COL_NAMA = "nama"
            val COL_ALAMAT = "alamat"
            val COL_JK = "jk"
            val COL_TELEPON = "telepon"
        }
    }
}