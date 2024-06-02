package kr.ryan.programmers.kotlin.level2

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Programmers
 * Class: HotelDayUse
 * Created by pyg941007.
 * Created On 2024-05-28.
 * Description: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */

fun main(){

    val bookTime = arrayOf(arrayOf("15:00", "17:00"), arrayOf("16:40", "18:20"), arrayOf("14:20", "15:20"), arrayOf("14:10", "19:20"), arrayOf("18:20", "21:20"))
    val bookTime2 = arrayOf(arrayOf("09:10", "10:10"), arrayOf("10:20", "12:20"))
    val bookTime3 = arrayOf(arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"))

    println(solution(bookTime))
    println(solution(bookTime2))
    println(solution(bookTime3))
}

fun solution(book_time: Array<Array<String>>): Int {

    val convertSchedule = arrayListOf<Schedule>()
    book_time.forEach {
        convertSchedule.add(Schedule(changeStringToCalendar(it[0]), addEndTime(it[1])))
    }

    val scheduler: Queue<Schedule> = LinkedList()
    scheduler.addAll(convertSchedule.sortedBy { it.startTime })

    val room = arrayListOf<Schedule>()

    while (scheduler.isNotEmpty()){
        val currentSchedule = scheduler.poll() ?: break
        if (room.isEmpty()){
            room.add(currentSchedule)
            continue
        }

        if (!checkSchedule(room, currentSchedule)){
            room.add(currentSchedule)
        }

    }

    return room.size
}

fun checkSchedule(list: ArrayList<Schedule>, current: Schedule): Boolean{
    for (index in list.indices){
        if(list[index].endTime <= current.startTime){
            list[index] = current
            return true
        }
    }
    return false
}

fun changeStringToCalendar(time: String): Long{
    return SimpleDateFormat("HH:mm", Locale.getDefault()).parse(time)!!.time
}

fun addEndTime(time: String): Long{
    val calendar = Calendar.getInstance().apply {
        this.time = SimpleDateFormat("HH:mm", Locale.getDefault()).parse(time)!!
        set(Calendar.SECOND, 0)
    }
    calendar.add(Calendar.MINUTE, 10)
    return calendar.time.time
}

data class Schedule(val startTime: Long, val endTime: Long)