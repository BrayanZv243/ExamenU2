package mx.itson.edu.examenu2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var adapter: RegalosAdapter? = null
    var myRegalos = ArrayList<Detalles>()


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
                myRegalos.add(Detalles(R.drawable.cumplebotanas,"280"))
                myRegalos.add(Detalles(R.drawable.cumplecheve,"320"))
                myRegalos.add(Detalles(R.drawable.cumpleescolar,"330"))
                myRegalos.add(Detalles(R.drawable.cumplepaletas,"190"))
                myRegalos.add(Detalles(R.drawable.cumplesnack,"150"))
                myRegalos.add(Detalles(R.drawable.cumplevinos,"370"))
            }

            "Globos" -> {
                myRegalos.add(Detalles(R.drawable.globoamor,"240"))
                myRegalos.add(Detalles(R.drawable.globocumple,"820"))
                myRegalos.add(Detalles(R.drawable.globofestejo,"260"))
                myRegalos.add(Detalles(R.drawable.globonum,"760"))
                myRegalos.add(Detalles(R.drawable.globoregalo,"450"))
            }

            "Peluches" -> {
                myRegalos.add(Detalles(R.drawable.peluchemario,"320"))
                myRegalos.add(Detalles(R.drawable.pelucheminecraft,"320"))
                myRegalos.add(Detalles(R.drawable.peluchepeppa,"290"))
                myRegalos.add(Detalles(R.drawable.peluchesony,"330"))
                myRegalos.add(Detalles(R.drawable.peluchestich,"195"))
                myRegalos.add(Detalles(R.drawable.peluchevarios,"225"))
            }

            "Tazas" -> {
                myRegalos.add(Detalles(R.drawable.tazaabuela,"120"))
                myRegalos.add(Detalles(R.drawable.tazalove,"120"))
                myRegalos.add(Detalles(R.drawable.tazaquiero,"280"))
                myRegalos.add(Detalles(R.drawable.tazas,"330"))
            }

            "Regalos" -> {
                myRegalos.add(Detalles(R.drawable.regaloazul,"80"))
                myRegalos.add(Detalles(R.drawable.regalobebe,"290"))
                myRegalos.add(Detalles(R.drawable.regalocajas,"140"))
                myRegalos.add(Detalles(R.drawable.regaloazul,"85"))
                myRegalos.add(Detalles(R.drawable.regalocolores,"75"))
                myRegalos.add(Detalles(R.drawable.regalovarios,"85"))
            }
        }
    }

    class RegalosAdapter: BaseAdapter{
        var regalos = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, regalos: ArrayList<Detalles>){
            this.regalos = regalos
            this.context = context
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
        override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
            var regalo = regalos[position]
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.activity_detalle_regalos,null)

            var imagen = vista.findViewById(R.id.iv_regalo_imagen) as ImageView
            var titulo = vista.findViewById(R.id.tv_regalo_precio) as TextView

            imagen.setImageResource(regalo.Image)
            titulo.setText(regalo.precio)

            return vista
        }

    }
}