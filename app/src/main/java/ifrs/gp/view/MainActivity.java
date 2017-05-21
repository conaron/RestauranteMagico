package ifrs.gp.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import ifrs.gp.R;
import ifrs.gp.controler.*;

public class MainActivity extends AppCompatActivity {
    private PedidoController pedidoCont;
    private ItemController itemCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedidoCont = new PedidoController(this);
        itemCont = new ItemController(this);

        TabHost abas = (TabHost) findViewById(R.id.tabhost);
        abas.setup();
        abas.addTab(abas.newTabSpec("aba1").setIndicator(getString(R.string.txt_bebidas)).setContent(R.id.bebidas));
        abas.addTab(abas.newTabSpec("aba2").setIndicator(getString(R.string.txt_lanches)).setContent(R.id.lanches));

        FloatingActionButton btnLimpar = (FloatingActionButton) findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCont.carrega();
            }
        });

        FloatingActionButton btnConfirmar = (FloatingActionButton) findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedidoCont.fecha_pedido();
            }
        });
        itemCont.carrega();
    }

}
