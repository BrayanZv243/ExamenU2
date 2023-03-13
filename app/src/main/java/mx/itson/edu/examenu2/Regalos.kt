package mx.itson.edu.examenu2

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class Regalos : AppCompatActivity() {
    var adapter: RegalosAdapter? = null
    var myRegalos = ArrayList<Detalles>()

    var detalles: String = "250"
    var globos: String = "300"
    var peluches: String = "200"
    var regalos: String = "150"
    var tazas: String = "200"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption: String? = intent.getStringExtra("menuType")
        cargarRegalos(menuOption)
        val gridview: GridView = findViewById(R.id.myGrid)
        adapter = RegalosAdapter(this,myRegalos)
        gridview.adapter = adapter
    }

    fun cargarRegalos(option:String?) {
        when (option) {
            "Detalles" -> {
                myRegalos.add(Detalles(R.drawable.cumplebotanas,"Detalles",detalles))
                myRegalos.add(Detalles(R.drawable.cumplecheve,"Detalles",detalles))
                myRegalos.add(Detalles(R.drawable.cumpleescolar,"Detalles",detalles))
                myRegalos.add(Detalles(R.drawable.cumplepaletas,"Detalles",detalles))
                myRegalos.add(Detalles(R.drawable.cumplesnack,"Detalles",detalles))
                myRegalos.add(Detalles(R.drawable.cumplevinos,"Detalles",detalles))
            }

            "Globos" -> {

            }
        }
    }

    class RegalosAdapter: BaseAdapter{
        var regalos = ArrayList<Detalles>()
        var contexto: Context? = null

        constructor(context: Context, regalos: ArrayList<Detalles>){
            this.regalos = regalos
            this.contexto = context
        }

        override fun getCount(): Int {
            return regalos.size
        }

        override fun getItem(p0: Int): Any {
            return regalos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("MissingInflatedId")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var regalo = regalos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.activity_regalos,null)

            var imagen = vista.findViewById(R.id.iv_regalo_imagen) as ImageView


            return vista
        }

    }
}