package mx.edu.itson.potros.practica5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnAtojitos: Button = findViewById<Button>(R.id.button_cold_drinks)
        var btnEspecialidades : Button = findViewById<Button>(R.id.button_hot_drinks)
        var btnCombinaciones : Button = findViewById<Button>(R.id.button_combinations)
        var btnTortas : Button = findViewById<Button>(R.id.button_tortas)
        var btnSopas : Button = findViewById<Button>(R.id.button_sopas)
        var btnDrinks : Button = findViewById<Button>(R.id.button_drinks)

        btnAtojitos.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Antojitos")
            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Especialidades")
            startActivity(intent)
        }
        btnCombinaciones.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Combinaciones")
            startActivity(intent)
        }
        btnTortas.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Tortas")
            startActivity(intent)
        }
        btnSopas.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Sopas")
            startActivity(intent)
        }
        btnDrinks.setOnClickListener {
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Drinks")
            startActivity(intent)
        }
    }
}