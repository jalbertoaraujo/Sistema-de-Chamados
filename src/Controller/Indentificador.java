package Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import View.sugestao;

import View.sugestao;

public class Indentificador {

	public void indentifica() {
		String ip = "";
		try{
			ip = InetAddress.getLocalHost().getHostAddress();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		sugestao.tfindentificador.setText(ip);		

	}

}
