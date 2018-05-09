import java.util.*
import kotlin.math.exp


fun <E> List<E>.rotateLeft(n:Int): List<E>{
    val rotation = n % this.size
    val resultList = mutableListOf<E>()
    resultList.addAll(this.subList(rotation,this.size))
    resultList.addAll(this.subList(0,rotation))
    return resultList
}

data class Matrix(val fields: List<List<Int>>){

    val rows = fields.size
    fun rotateMatrix(n: Int): Matrix{
        if(this.isEmpty())
        {
            return this
        }
        else
        {
            val unwrap = this.unwrap()
            return rotateInternal(n,unwrap.second, unwrap.first, this.rows)
        }
    }

    fun rotateInternal(n: Int, wrap: List<Int>, matrix: Matrix, rows: Int):Matrix{
        val newWrap = wrap.rotateLeft(n)
        val rotateMatrix = matrix.rotateMatrix(n)
        return rotateMatrix.wrapWith(newWrap, rows)
    }

    fun  subMatrix():Matrix{
        val mutableMatrix = mutableListOf<List<Int>>()
        for (i in 1..fields.size-2){
            val list = fields[i]
            mutableMatrix.add(list.subList(1,list.size-1))
        }
        return Matrix(mutableMatrix)
    }

    fun wrapWith(unwrappedList: List<Int>, expectedRows: Int): Matrix{
        //assertions go her
        val mutableList = mutableListOf<List<Int>>()
        val size = unwrappedList.size
        val cols = calculateColumns(size, expectedRows)

        mutableList.add(unwrappedList.subList(0,cols))
        if(currentColumns()>0)
        {
            fields.forEachIndexed { index, list ->
                val last = unwrappedList[cols + index]
                val first = unwrappedList[size -1-index]
                val linkedList = LinkedList<Int>(list)
                linkedList.push(first)
                linkedList.add(last)
                mutableList.add(linkedList.toList())
            }
        }
        else
        {
            for( index in 0..(expectedRows-2-1)){
                val last = unwrappedList[cols + index]
                val first = unwrappedList[size -1-index]
                mutableList.add(listOf(first,last))
            }
        }
        mutableList.add(unwrappedList.subList(cols+fields.size, size -fields.size).reversed())
        return Matrix(mutableList)
    }

    private fun calculateColumns(size: Int, expectedRows: Int) =
            if(currentColumns()>0){
                currentColumns()+2
            }
            else
            {
                size/ expectedRows
            }


    private fun currentColumns()=
        if(fields.isEmpty()) 0 else fields[0].size

    fun unwrap(): Pair<Matrix,List<Int>>{

        return Pair(this.subMatrix(), this.edge())
    }

    fun edge(): List<Int>{
        val edgeCells = mutableListOf<Int>()
        if(fields.isNotEmpty()) {
            edgeCells.addAll(fields[0])
            for (i in 1..fields.size - 2) {
                val lastCell = fields[i].size - 1
                edgeCells.add(fields[i][lastCell])
            }
            edgeCells.addAll(fields[fields.size-1].reversed())
            for (i in (fields.size - 2) downTo 1) {
                edgeCells.add(fields[i][0])
            }
        }
        return edgeCells
    }

    fun isEmpty():Boolean{
        return fields.isEmpty() || fields.map { it.isEmpty() }.reduce { acc, b -> acc && b }
    }

    fun print() {
        fields.forEach {row->
            row.forEach {
                print("$it ")
            }
            println()
        }
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val (m, _, r) = scan.nextLine().split(" ").map { it.trim().toInt() }
    val rows = mutableListOf<List<Int>>()
    repeat(m, {
        rows.add(scan.nextLine().split(" ").map { it.trim().toInt() })
    })

    val matrix = Matrix(rows)
    val rotate = matrix.rotateMatrix(r)
    rotate.print()
}