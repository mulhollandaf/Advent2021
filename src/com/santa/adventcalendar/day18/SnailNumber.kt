package com.santa.adventcalendar.day18

abstract class SnailNumber {
    var parent: PairSnailNumber? = null
}

class PairSnailNumber(var first: SnailNumber, var second: SnailNumber) : SnailNumber(){
    @Override
    override fun toString(): String {
        return "[$first,$second]"
    }
}

class ConstantSnailNumber(var value: Int): SnailNumber() {
    @Override
    override fun toString(): String {
        return value.toString()
    }
}


