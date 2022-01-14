package Proiect;

public class PlayerStatus {

	private String nickname;
	private int score;
	private int lives;
	private int health;
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private static String gameName;
	
	
	public void ititPlayer(String nickname) {
		this.nickname = nickname;
	}
	
	public void initPlayer(String nickname, int lives) {
		this.nickname = nickname;
		this.lives = lives;
	}
	
	public void initPlayer(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}
	
	
	public void afisare() {
		System.out.println("\tScor: " + this.score);
		System.out.println("\tNumar vieti: " + this.lives);
		System.out.println("\tProcent viata: " + this.health + "%");
		System.out.println("\tArma: " + this.weaponInHand);
		System.out.println("\tPozitia X: " + this.positionX + " , Y: " + this.positionY);
	}
	
	public void afisarePozitie() {
		System.out.println("X: " + this.positionX + " , Y: " + this.positionY);
	}
	
	public void setHealth(int health) {
		this.health = health;
		if(health > 100) {
			this.health = 100;
		}
	}
	
	public void healthPosibility() {
		if(this.health > 100) {
			this.health = 100;
		}
		
		if(this.health <= 0 ) {
			this.lives -= 1;
			this.health = 100;
		}
		if(this.lives < 1 && this.health == 0) {
			System.out.println("\n\tJocul s-a terminat!");
		}
	}
	
	public boolean isPerfect(int n) {
		int s = 0;
		for(int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				s += i;
			}
		}
		
		if(s == n) {
			return true;
		}
		return false;
	}
	
	public boolean isPrime(int n) {
		if(n < 2) {
			return false;
		}
		
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isMultiple3Even(int n) {
		if(n % 2 != 0) {
			return false;
		}
		int sum = 0;
		while( n > 0) {
			int lastDigit = n % 10;
			sum += lastDigit;
			n /= 10;
		}
		
		if(sum % 3 != 0) {
			return false;
		}
		return true;
	}
	
	public void findArtifact(int artifactCode) {
		if(isPerfect(artifactCode)) {
			this.score += 5000;
			this.lives += 1;
			this.health = 100;
			
		} else if(isPrime(artifactCode)) {
			this.score += 1000;
			this.lives += 2;
			this.health += 25;
			
		}else if(isMultiple3Even(artifactCode)) {
			this.score -= 3000;
			this.health -= 25;
		} else {
			this.score += artifactCode;
		}
		
		this.healthPosibility();
	}
	
	public boolean setWeaponInHand(String weapon) {
		int knifeCost = 1000;
		int sniperCost = 10000;
		int kalashnikovCost = 20000;
		boolean set = false;
		
		if(weapon.equals("sniper") && sniperCost <= this.score) {
			this.score -= sniperCost;
			this.weaponInHand = weapon;
			set = true;
		} else if(weapon.equals("knife") && knifeCost <= this.score) {
			this.score -= knifeCost;
			this.weaponInHand = weapon;
			set = true;
		}else if(weapon.equals("kalashnikov") && kalashnikovCost <= this.score) {
			this.score -= kalashnikovCost;
			this.weaponInHand = weapon;
			set = true;
		}
		
		return set;
	}
	
	public String getWeaponInHand() {
		return this.weaponInHand;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionX() {
		return this.positionX;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public double getPositionY() {
		return this.positionY;
	}
	
	public static String getGameName() {
		return gameName;
	}
	
	protected static void setGameName(String name) {
		gameName = name;
	}
	
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public String getNickName() {
		return this.nickname;
	}
	
	public double distanceBetweenPlayers(PlayerStatus oponent) {
		double distance = Math.sqrt(Math.pow((this.positionX - oponent.positionX) , 2) + Math.pow((this.positionY - oponent.positionY), 2));
		return distance;
	}
	
	public boolean shouldAttackOponent(PlayerStatus oponent) {
		boolean p = false;
		double probability1 = 0;
		double probability2 = 0;
		
		if(this.weaponInHand.equals(oponent.weaponInHand)) {
			probability1 = (3 * this.health + this.score / 1000) / 4;
			probability2 = (3 * oponent.health + oponent.score / 1000) / 4;
			
			if(probability1 > probability2) {
				p = true;
			}
		} else {
			if(this.distanceBetweenPlayers(oponent) > 1000) {
				if(this.weaponInHand.equals("sniper") && (oponent.weaponInHand.equals("kalashnikov") || oponent.weaponInHand.equals("knife"))) {
					p = true;
				}else if(this.weaponInHand.equals("kalashnikov") && oponent.weaponInHand.equals("knife")) {
					p = true;
				}
			} else {
				if(this.weaponInHand.equals("kalashnikov") && (oponent.weaponInHand.equals("sniper") || oponent.weaponInHand.equals("knife"))) {
					p = true;
				} else if(this.weaponInHand.equals("sniper") && oponent.weaponInHand.equals("knife")) {
					p = true;
				}
			}
		}
		return p;
	}
	
	public void duel(PlayerStatus oponent) {
		if(this.shouldAttackOponent(oponent)) {
			if(this.weaponInHand.equals("knife")) {
				oponent.health -= 60;
			} else if(this.weaponInHand.equals("sniper")) {
				oponent.health -= 100;
			} else if(this.weaponInHand.equals("kalashnikov")) {
				oponent.health -= 80;
			}
			
			this.healthPosibility();
		} else {
			if(oponent.weaponInHand.equals("knife")) {
				this.health -= 60;
			} else if (oponent.weaponInHand.equals("sniper")) {
				this.health -= 100;
			} else if(oponent.weaponInHand.equals("kalashnikov")) {
				this.health -= 80;
			}
			this.healthPosibility();
		}
	}
}
