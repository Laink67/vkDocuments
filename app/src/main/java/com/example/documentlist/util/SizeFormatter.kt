package com.example.documentlist.util

class SizeFormatter {
    fun format(size: Int): String {

/*
        when (size) {
            in KILOBYTE..MEGABYTE -> return "${size / KILOBYTE.toDouble()} Kb"
            in MEGABYTE..GIGABYTE -> return "${size / MEGABYTE.toDouble()} Mb"
            in GIGABYTE..Int.MAX_VALUE -> "${size / GIGABYTE.toDouble()} Gb"
        }
*/
        return if (size in KILOBYTE..MEGABYTE)
            "${size / KILOBYTE} Kb"
        else if (size in MEGABYTE..GIGABYTE)
            "${size / MEGABYTE} Mb"
        else if (size in GIGABYTE..Int.MAX_VALUE)
            "${size / GIGABYTE} Gb"
        else
            "$size Byte"
    }
}