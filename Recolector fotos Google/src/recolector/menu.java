package recolector;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class menu {
  String url = "";
  int cantidadFotos = 0;
  String ubicacionFotos ="";

  private void buildGUI() {
    JFrame frame = new JFrame("Recolector de fotos");
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());


    JLabel label = new JLabel("1.- Ingresa el termino de busqueda");
    JTextField textField = new JTextField(21);

    JLabel cantidad = new JLabel("2.- Ingresa cantidad de fotos a almacenar ");
    JTextField textField2 = new JTextField(17);
    
    JLabel direccion = new JLabel("3.- Ubica la direcci�n de guardado                                                                 ");

    JButton seleccionarUbicacion = new JButton();
    seleccionarUbicacion.setText("...");

    JLabel obtener = new JLabel("4.- Obtener imagenes                                                                                        ");
    JButton button = new JButton();
    button.setText("ok");

    JButton salir = new JButton();
    salir.setText("Salir");

    seleccionarUbicacion.addActionListener(new ActionListener() {

      @Override
        public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser chooser = new JFileChooser(); 
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int returnVal = chooser.showOpenDialog(label); 
        if (returnVal == JFileChooser.APPROVE_OPTION) { 
          ubicacionFotos = chooser.getSelectedFile().getAbsolutePath();
        }
      }
    }
    );

    button.addActionListener(new ActionListener() {
      @Override
        public void actionPerformed(ActionEvent e) {
        url = textField.getText().trim();
        cantidadFotos = Integer.parseInt(textField2.getText());
        frame.setVisible(false);

        try {
          new Bot(url, cantidadFotos, ubicacionFotos).start();
        } 
        catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    }
    );

    salir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 System.exit(0); 
		}
	});
    panel.add(label);
    panel.add(textField);
    panel.add(cantidad);
    panel.add(textField2);
    panel.add(direccion);
   // panel.add(textField3);
    panel.add(seleccionarUbicacion);
    panel.add(obtener);
    panel.add(button);
    panel.add(salir);
    frame.add(panel);
    frame.setSize(500, 150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    frame.setUndecorated(true);
    frame.setVisible(true);
    

  
  }

  public menu() {
    buildGUI();
  }

  public static void main(String[] args) {
    new menu();
  }
}


/*
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
#@@@@@@@@@@@@@@@@@###@@@@@@@@@@@@#@@@@@@@@@@@@@@@@@###@@@@@@@#####@@###@#@@@@@##+##+#@
@############################@####@@@@@@###@####@########@@@@##+#@########@@@@##++#'#@
@##########################@@@@####+##@@@@#@@###@@######@@@@@@###########@@@@@@@###+#@
###############@#############@##+++##''#@@@@@@###@######@@@@@@@##########@@@@@@@###+#@
###########################@@#++++++##+'#@@@@@@@@#######@@@@@@@#@@#######@@@@@@@###+#@
#######@#####@#############@@#++'+++####+###@@@@@#######@@@@@@@@@@@@@####@@@@@@@#@#++@
###########################@@+'''+++#####'###@@@@@@@@@@@@@@@@@@@@@@#@#@@@@@@@@@@@@#++@
@####################@#@@@@@#+++'''++####''########@@@@@@@@@@########@@@@@@@@@@@@@#++@
####################@@@@@@@@#+++''''+####+;+########@@@@@@@###########@@@@@@@@@@@@@++@
#######@##########@@@@@@@@@@#++''+''''++++;;+########@@@@@#############@@#@@@@@@@##++@
#################@@@@@@@@@@@#'''''++++''+';:;+#@######@@@#########+'+###@@@@##@@###++@
@#@########@#####@@@@@@@@@@@#''+++++++''''';;'+#######@@#########':;;'++##@@@###+##++@
########@@##@##@#@@@@@@@@@@@#'+++++#+'';''';:;'+####@@@@@######+;;;'''++###@###++##++@
####@##@########@@@@@@@@@@@@+''+##+'''''';;;:;;''++#@@@@@@####+;:;'''++#########+##++@
#@#####@######@#@@@@@@@@@@@@+'+++'++''''';;;:;;;;;''+#++##+++';::'''+++##@@@@###+##++@
##@##@#@######@##@@@@@@@@@@@#'++++++';;';;;::::::;;;;;'''''+;:::;''++++#@@@@@###+###+@
#####@######@@@@@@@@@@@@@@@@@+'++'''';;;;;;:::::::;;::;;;;;;;:::;'''++#@@@@@@@######+@
#@########@#@@@@@@@@@@@@@@@@@@''++++';;;;::::::::::::;::;;::::::;''''+##@@@@@@@@####+@
#########@@@@@@@@@@@@@@@@@@###+''++'';;;::::::::::::::::::::::::;;''++#@@@@@@@@@@@##+@
@###########@#@@@@@@@@@@@@@##+++'++'';;;::::::::::::::::::::::::;'''''##@@@@@@@@@@@#+@
############@####@@@@@@@#++++''''''';;;::::::::,:::::::::::::::::;''''##@@@@@@@@@@@@+@
###@#@######@##@@@@@@@@@#+''';;''''';;;;:::::::::::,:::::::::::::;'''+##@@@@@@@@@@@@+#
#######@####@##@@@@@@@@@++'''';;';;';;;;::::::::::::,::::::::::::;'''+@@@@#@@@@@@@@@+#
#######@#####@@@@@@@@@@@#+''''''';;;;;;;::::::::::::::::,::::::::;'''##@@@##@@@@@@##+#
@#@##########@@@@@@@@@@#+''''''''';;;;:::::::::::,::::::::::::::;;''+##@@@@@@@@@####+#
@@@@#####@@@@@@@@@@@###++'''''''';;;;;:;;::::::::,::::::,::::::::;;+#####@@@@##++###+#
@@@@#@@@@@@@@@@@@@@@#+++'''''''';;;;;;:::::::::::::::::::,:::::;;;;+#######@########+#
#@#@#@#@@@@@@@@@@@####''''''';;;;;;;;:::;;+#;:::,:::,,::::::::::;;'+#########+######+#
@##@@@@@@@@@@@@#@@@#+'';';;;;;;;;;;;;:::'@#@#::::,:,,,::::,:::::;;'+######@@########+#
###@@@@@@@@@@@@@@@#+'';;;;;;;;:;;::;;::;@@#@#::,,,,,,,,,::::;::::;;+####@@@@@@###+####
@#@@#@@@@@@@@@@@@##+;;;;::;::::::::;;::+@@;;#::,,,,,,,,,,,,:::;;:;;'+##@##@@#@@#+#####
#@@@@@#@@@@@##@#@#+';;;::;:::::::::::::'@@#+;::,,,,,,,,,,,,''::;:;;;'####++##@@@######
##@@@@@@@@@@####+';;;;:::::::::::::::::;'++;::,,,,,,,,,,,,;#@;:::;;;+##########@#@@###
#@@@@@@@@@@@@##''';;;;:::::::::::::::::::::::,,,,,,.,,,,,,,;@+:::;;;+++#++#@@###;@@@#+
#@@@@@#@@@@@@#+'';;;:::;;::::::::::::::,::,,,,,,,,.,,,,,,,;+#';::;;;'+######@###;+:;;+
@@#@@@@@@@@##+'';;;;::;;::;::;;::::::::,:,,,,,,,,,..,,,,,,;##;;;;;;;;+++#####'';;;::::
@####@@#@###'''';;::::;;::;:;;:;::::::::,,,:,,,,,,...,,,,,:'':;;;;;;'+####+++:::::::;;
#######@##@#+'';;;;;;;;;::;:;:::::::::,:,,,::::,,,,,,,,,,,::::;;;;;;'+##@++++:::::;::,
#######@@##+''';;;;;;;;;:::;;::::::::,:,,::::::,,,,..,,,,::::::;;;;;;+;+;+;;:,::;;;::,
#######@#@+''';;;;;;;'';::;;:,::::::,,,,,::::::,,....,,,,::::::;;;;;;;::::;:::;;;;::,,
##@@######++';;;;;;;;'';::;;::::::::,,,,:::::::,,,,.,,,,,::::::::;;;;;:::,;::;;;;:::::
#@@@###@#+'';;;;;;;;::::::::::::::,,,,,:::::::::,,,,,,,,,::::::::::;;:::::;;:;::::::::
#@@@##@##+';;;;;;;;:,::,:::,,:::::::,,,::::::::::::,,,,::::::::::::;;;:::::::;;;::::::
#@@@@@##+'';;;;;;;;:::;:,::,,:::::,,,,,:::::::::::::,,:::::::::::::;;:::,:,,::::::,:,:
#@@@@@##+'';;;;;;;;:::::::,..::::,,,,,,,:::::::::::::::::::::::::::;;::,:::,::::::,,::
#@@@@@##+';;;;;;;:;;:,,,,,,.,,,:::,,,,,:::::::::::::::::::::::::::::;:::::::::::::::,,
#@@@@@#+''';;;;;;:;;;:,:,,,,,,::::::,,,,:::::::::::::::,,,::::::::::;::::;::::::::::::
#@@@@@@#''';;;;;;;;;;;:::::::::;;:::,,,,,::::::;:::::::::,,:::::::::;;:::;:,;:::::,;;;
#@@@@@@#+'';;;;;;;:;;:::,,,::::;;;::,,,,,,::::::::::::,,,,,,:,,:::::;';;:,,::::,,,,:,:
@@@@@@@#+''';;;;;:::::,,,,,:::;;;;;:::,,,,,,::::;;::::,,,,:,:::,,,::;;::::,::::::::::,
#@@@@@@#+''';;;;;:::::,,,,,:::;;;;;;:::,,,,,::::;;;:::,,,,:::,:::,,::::,:;:::,,:::::,,
@@@@@@@@#+'';;;;;:::::,,,,:::::;;;;;;:;;:,,,,,,:';:::,,,,,,:,,,::::::::,;;:::,::::::,,
@@@@@@@@#+'';;;;;::::,,,,,,:::::;;;;;:::::;::::::,,,,,,,,,,,:,:,,:::::,:;;:;:::::,::,,
@@@@@@@@#+'';;;;;:::,,,,,,,,:::;:;;:;:::,,,:::::;:,,,,,,,:::::,:::::::,:::::;,,:;,,,,,
@@@@@@@@@++';;;;:::::,,,,,,,:::::;;:::::,,,,:::::::::,,,:::::::::,:::,:::::;:,,::,,,,,
#@@@@@@@@#+'';;;:::::,,,,,,:::::::::::::,,,:,,,,,,,,::::::::::::::::::::::,,::::::,,,,
@@@@@@@@@#++';;;::::::,,,,::::::::::::,,,,,,:::,:,,::::::::::,::::::;:,:;::,,,,;,,,,,,
@@@@@@@@@@#'';;;;::::,,,:::::::::::::,,,...,,::::::::::::::::,:::::::::;;;:,,,:,,:,,,,
@@@@@@@@@@#+';;;;::::,,::::::::::::::,,...,,,:::::::::::::::::::::::::;;::::,,:,,,:,:,
@@@@@#@@@@#++'';;:::::::::::::::::::,,....,,,:::::::::::,:::::::::::::::::;:::::,,::,,
@@@@@@@@@#+++'';;;::::::::::::::::::,,..,,,:::::::::,:,:,,,,::::::::::::;;:::::,:,,:,,
#@@@@@@@@++++'';;;::::::::::::::::::,,,,,:::::::::,,,,,,,,,,,,:::::::::;:::::,,:,,,,,,
#@@@@@@@@++'++'';;;;:::::::::::::::,,,::::::::::::,,::,,,,,,,:::::::::;;:::::,::,,,,,.
@@@@@@@@#++''''';;;;::::::::::::::,,,,:::::::::::::,::::,,,,:::::::;;;;;::::;:::::,,,.
@@@@@@@@@++''''';;;;::::::::::::,,,,:::::::::::::,,::::,,,,,:::::::;;;:::::;;;::::,:,,
#@@@@@@@@++''';;;;;;;:::::::::::,,,,:::::::::::::::::::,,,,,,::::;:;;;::::;::,:::,,,::
#@@@@@@@##+''';;;;;;;;::::::::::,,,:::::::::::::::::::,,,,,,,::::::;;;:,,::::,,;:::::,
@@@@@@@@@@#'''';;;;;;;:::::::::,,,,::::::::::::::::::::,,,,,::::::;;;;::,,:;::::::::,:
@@@@@@@@@@#++'';;;;;;;;;::::::::::::::::::::::::,:,::,,,,,,,::::::;;;;;:::::::;,:::,::
@@@@@@@@@@##+'';;;;;;;;::::::::::::::::::::::::,,,,:,,,,,,,:::::::;;;;;;::,,,::,::::;:
#@@@@@@@@@@@+'';;;;;;;;:::::::::::;::::::::::,,,,,,,,,,,,,,:::::::;;;;;;::,,,:,,::,,,:
#@@@@@@@@@@#+'''';;;;;:;:::::::::::;::::::::,,,,,,,,,,,,,::::::::::;;;;;::,,,:,,,:,.,,
#@@@@@@@@@@@#++''';;;;;;::::::::;;;;::::::::,,,,,,,,,,,,,::::::::::;;;;;::,,:,,,,::,,,
#@@@@@@@@@@@#++'';;;;;;;;;;::::::;;;::::,,,,,,,,,,,,,,,:::::::::::::;;;;:::,::,,,:,,,,
#@@@@@@@@@@@@+++'';;;;;;;;;::::;;;;;::::,,,,,,,,,,,,,,,:::;:::::::;;;::::::::,,,:;:,.,
#@@@@@@@@@@@@+'''''';;;;;;::;::;;;;;:::,,,...,,,,,,,,,,:::::::::::::::::::::::::::::::
#@@@@@@@@@@@@+'''''';;;;;;::;;:;;;;;;:,,.......,,,,,,,,:::::::::::::::::::::;:::::,:::
#@@@@@@@@@@@@+';'''';;;;;;;;;;:;;;::,,.........,,,,,,,::::::::::::::::::::::,.,::;,;,:
#@@@@@@@@@@@@++''';'';;;;;;;;;;;':,,,,,........,,,,:,:::::::::,:::::::::::::::;:::,,,:
#@@@@@@@@@@@@#+'';;';';;;;;;;;;'.,,,,,,,.......,,,,:::::::::::::::::::::::::::,:,,.:,,
@@@@@@@@@@@@@@#+'';';;;;;;::;;;,,.,,,.,,.....,,,,,::::::::::::::::::::::::::::,;:,,:,,
@@@@@@@@@@@@@@#+'';';;;;;;:;;;,,,,,,...,,...,,,,::::::::::::::::::::,:::::::::::;:,,,,
@@@@@@@@@@@@@@@#+';''';;;;;'''::,,,.,,.,,..:,,,:::::::::::::::::,,,:,,:::::::::;:,,:::
@@@@@@@@@@@@@@@##+'''';;;;;''+';:,.,,,,,,.,;:;::::::::::::::::::,,,,,,,:::,:::::,,.,,.
@@@@@@@@@@@@@@@@@+'''';;;;;;''';:::,,.,,,,:;:::::::::::::::::,,,,,,,,,,,:,::::,::;:;,.

*/