package mx.itson.edu.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var btnTazas: Button =findViewById(R.id.btn_taza) as Button
        var btnRegalos:Button=findViewById(R.id.btn_regalos) as Button
        var btnPeluches:Button=findViewById(R.id.btn_peluches) as Button
        var btnGlobos:Button=findViewById(R.id.btn_globos) as Button
        var btnDetalles:Button=findViewById(R.id.btn_detalles) as Button

        var intent: Intent =Intent(this,Regalos::class.java)

        btnTazas.setOnClickListener{

            intent.putExtra("menuType", "Tazas")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener{
            intent.putExtra("menuType", "Regalos")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener{
            intent.putExtra("menuType", "Peluches")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener{
            intent.putExtra("menuType", "Globos")
            startActivity(intent)
        }
        btnDetalles.setOnClickListener{
            intent.putExtra("menuType", "Detalles")
            startActivity(intent)
        }


    }
}