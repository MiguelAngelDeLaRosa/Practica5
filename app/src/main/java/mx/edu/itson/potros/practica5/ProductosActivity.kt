package mx.edu.itson.potros.practica5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.util.ArrayList

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        var option : String? = intent.getStringExtra("menuType")
        var img : ImageView = findViewById<ImageView>(R.id.imageView)
        when(option) {
            "Antojitos" ->{
                img.setImageResource(R.drawable.antojitos)
            }
            "Especialidades" ->{
                img.setImageResource(R.drawable.especialidades)
            }
            "Combinaciones" ->{
                img.setImageResource(R.drawable.combinations)
            }
            "Tortas" ->{
                img.setImageResource(R.drawable.tortas)
            }
            "Sopas" ->{
                img.setImageResource(R.drawable.sopas)
            }
            "Drinks" ->{
                img.setImageResource(R.drawable.drinks)
            }
        }
        agregarProducto(option)

        var listview : ListView = findViewById(R.id.litview)
        var adapatador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adapatador
    }

    fun agregarProducto(option: String?){
        when(option){
            "Antojitos" ->{
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servida con ensalada.", 5.69))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema", 4.69))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña Fluor tortilla con queso marinado, puerco y piña", 7.99))
                menu.add(Product("Sincronizadas", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamon", 10.50))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechiga, queso fresco y crema Field", 7.69))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla", 6.69))
            }
            "Especialidades" ->{
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, agaucate y tortillas", 17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones. Aguacate y pico de gallo", 6.99))
                menu.add(Product("Botana de camarones", R.drawable.botanacamarones, "Botana de camarones al mojo de ajo", 19.99))
            }
            "Combinaciones" ->{
                menu.add(Product("Tradicional taco combo", R.drawable.taco, "Tortilla de maiz y tu carne favorita", 6.99))
                menu.add(Product("Burritos", R.drawable.burritos, "Tu carne favorita en una tortilla grande con harina rellena de cebolla", 12.99))
                menu.add(Product("Los portales burrito", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus", 13.59))
                menu.add(Product("Cinco", R.drawable.cinco, "One hard cell taco with your choice of meet", 9.99))
                menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meet topped with lettuce", 9.99))
            }
            "Tortas" ->{
                menu.add(Product("Torta regular", R.drawable.torta, "All tortas come with lettuce, onions, tomato, avocado", 12.99))
                menu.add(Product("Torta milanesa de res de pollo", R.drawable.tortamilanesa, "Breaded steak or chicken", 13.99))
                menu.add(Product("Torta cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso Mexican", 13.99))
                menu.add(Product("Torta mixta", R.drawable.tortamixta, "Chorizo, asada, y pastor", 9.99))
            }
            "Sopas" ->{
                menu.add(Product("Pozole", R.drawable.pozole, "Weekends only", 5.99))
                menu.add(Product("Menudo", R.drawable.menudo, "Breaded steak or chicken", 5.99))
                menu.add(Product("Caldo de res", R.drawable.caldores, "", 5.99))
                menu.add(Product("Caldo de camaron", R.drawable.caldocamaron, "Shrim soup", 13.99))
            }
            "Drinks" ->{
                menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.99))
                menu.add(Product("Caguama", R.drawable.caguama, "", 3.99))
            }
        }
        }
    }

private class AdaptadorProductos: BaseAdapter {
    var productos = ArrayList<Product>()
    var contexto : Context?= null

    constructor(context: Context, producto: ArrayList<Product>){
        this.contexto = context
        this.productos = producto
    }

    override fun getCount(): Int {
        return productos.size
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = productos[position]
        var inflador = LayoutInflater.from(contexto)
        var vista = inflador.inflate(R.layout.producto_view, null)

        var imagen = vista.findViewById<ImageView>(R.id.producto_img)
        var nombre = vista.findViewById<TextView>(R.id.producto_nombre)
        var desc = vista.findViewById<TextView>(R.id.producto_desc)
        var precio = vista.findViewById<TextView>(R.id.producto_precio)

        imagen.setImageResource(prod.image)
        nombre.setText(prod.name)
        desc.setText(prod.description)
        precio.setText("$${prod.price}")
        return vista
    }
}