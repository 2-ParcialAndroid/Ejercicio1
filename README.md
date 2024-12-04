# Horario Inteligente
Francisco Carlos López Soto 
Link al repo:https://github.com/2-ParcialAndroid
Horario Inteligente es una aplicación de Android que permite a los usuarios agregar, ver y consultar su horario de clases.

## Características

- **Agregar Clase**: Permite a los usuarios agregar una nueva clase a su horario.
- **Ver Horario**: Permite a los usuarios ver el horario completo de un día específico.
- **Clase Actual**: Muestra la clase actual basada en el día y la hora.

## Estructura del Proyecto

El proyecto está estructurado en las siguientes actividades principales:

1. **MainActivity**: La actividad principal que permite la navegación a las otras actividades.
2. **AddClassActivity**: Permite a los usuarios agregar una nueva clase a la base de datos.
3. **ViewScheduleActivity**: Permite a los usuarios ver el horario de un día específico.
4. **CurrentClassActivity**: Muestra la clase actual basada en el día y la hora.

## Implementación

### MainActivity

La `MainActivity` contiene botones para navegar a las otras actividades.

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_class).setOnClickListener(v -> {
            startActivity(new Intent(this, AddClassActivity.class));
        });

        findViewById(R.id.btn_view_schedule).setOnClickListener(v -> {
            startActivity(new Intent(this, ViewScheduleActivity.class));
        });

        findViewById(R.id.btn_current_class).setOnClickListener(v -> {
            startActivity(new Intent(this, CurrentClassActivity.class));
        });
    }
}
