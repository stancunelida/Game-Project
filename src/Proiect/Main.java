package Proiect;

public class Main {
	
	public static void main(String[] args) {
		
		PlayerStatus player1 = new PlayerStatus();
		PlayerStatus player2 = new PlayerStatus();
		
		PlayerStatus.setGameName("War");
		
		player1.initPlayer("Sol", 3, 1500);
		player2.initPlayer("Anon", 3, 20000);
		
		player1.setHealth(100);
		player2.setHealth(100);
		player1.setWeaponInHand("knife");
		player2.setWeaponInHand("knife");
		player1.setPositionX(200);
		player1.setPositionY(200);
		player2.setPositionX(500);
		player2.setPositionY(1000);
		player1.movePlayerTo(200, 200);
		player2.movePlayerTo(500, 1000);
		
		System.out.println("\t\t\t\t" + PlayerStatus.getGameName());
		System.out.println("Jucatorii sunt: " + "\n\t" + player1.getNickName() + " si " + player2.getNickName());
		System.out.println(player1.getNickName() + " are initial: " );
		player1.afisare();
		System.out.println(player2.getNickName() + " are initial: " );
		player2.afisare();
		System.out.println("==========Lupta incepe========");
		System.out.println(" ");
		player2.movePlayerTo(100, 150);
		System.out.println(player2.getNickName() + " se afla pe pozitia: ");
		player2.afisarePozitie();
		player2.findArtifact(13);
		player2.setWeaponInHand("kalashnikov");
		System.out.println("Gaseste un artefact car ii aduce puncte in plus, pe care il foloseste sa isi cumpere "
				+player2.getWeaponInHand());
		player1.movePlayerTo(150, 90);
		player1.findArtifact(24);
		System.out.println(player1.getNickName() + " ajunge in pozitia :");
		player1.afisarePozitie();
		player1.setWeaponInHand("sniper");
		System.out.println(player1.getNickName() + " are acum: ");
		player1.afisare();
		System.out.println(player2.getNickName() + " are acum: ");
		player2.afisare();
		System.out.println("Distanta dintrs cei doi jucatori este: " + player1.distanceBetweenPlayers(player2));
		player2.duel(player1);
		System.out.println(player1.getNickName() + " reuseste sa il nimereasca pe " + player2.getNickName());
		player2.movePlayerTo(50, 86);
		System.out.println("Desi este ranit " + player2.getNickName() + " reuseste sa ajunga pe pozitia: ");
		player2.afisarePozitie();
		player2.setWeaponInHand("knife");
		player2.findArtifact(18);
		player1.duel(player2);
		player1.setWeaponInHand("sniper");
		player2.findArtifact(6);
		player1.findArtifact(36);
		player2.duel(player1);
		System.out.println("Dupa o serie de dueluri intre cei doi: ");
		player1.setHealth(0);
		player1.setWeaponInHand("knife");
		player1.healthPosibility();
		System.out.println(player1.getNickName() + " are acum: ");
		player1.afisare();
		System.out.println(player2.getNickName() + " are acum: ");
		player2.afisare();
		player1.movePlayerTo(150, 150);
		player2.movePlayerTo(150, 150);
		System.out.println("Acum cei doi jucatori se afla pe acceasi pozitie.");
		player1.afisarePozitie();
		player2.afisarePozitie();
		player2.duel(player1);
		player2.duel(player1);
		player2.duel(player1);
		player2.duel(player1);
		player2.duel(player1);
		player1.setHealth(0);
		player1.healthPosibility();
		System.out.println("Dupa o serie de dueluri:");
		System.out.println("Sol are: ");
		player1.setHealth(0);
		player1.afisare();
		System.out.println("Anon are: ");
		player2.afisare();
		System.out.println(player1.getNickName() + " moare " + "\n\t\t\t\t Jocul s-a terminat!");
		
		
		
		
	}

}
