package obstacles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: testPlanetMaker
 * Description: This defines all the methods and attributes needed to create all Planet objects and set to arraylist
 *
 * @author Kenny Cauthen
 * @version 0.0.1, 11/5/2015
 *          Course: ITEC 3860 Fall 2015
 *          Assignment: Final Project
 */
public class PlanetMaker {
	private ArrayList<Planet> planetArrayList = new ArrayList<>();


	public PlanetMaker() {
		String[] planetList = getPlanetList();
		String[] exploreMessageList = getExploreMessageList();
		String[] scanMessageList = getScanMessageList();
		String[] arrivalMessageList = getArrivalMessageList();
		Collections.addAll(planetArrayList,
				//Planet Name, Arrival Message,Scan Message, Explore Message, Explore Flag, Planet Flag, Planet Explored)
				new Planet(planetList[0], arrivalMessageList[0], scanMessageList[0], exploreMessageList[0], 0, 1, false),
				new Planet(planetList[1], arrivalMessageList[1], scanMessageList[1], exploreMessageList[1], 0, 3, false),
				new Planet(planetList[2], arrivalMessageList[2], scanMessageList[2], exploreMessageList[2], 0, 1, false),
				new Planet(planetList[3], arrivalMessageList[3], scanMessageList[3], exploreMessageList[3], 0, 3, false),
				new Planet(planetList[4], arrivalMessageList[4], scanMessageList[4], exploreMessageList[4], 2, 0, false),
				new Planet(planetList[5], arrivalMessageList[5], scanMessageList[5], exploreMessageList[5], 2, 2, false),
				new Planet(planetList[6], arrivalMessageList[6], scanMessageList[6], exploreMessageList[6], 2, 0, false),
				new Planet(planetList[7], arrivalMessageList[7], scanMessageList[7], exploreMessageList[7], 2, 0, false),
				new Planet(planetList[8], arrivalMessageList[8], scanMessageList[8], exploreMessageList[8], 2, 0, false),
				new Planet(planetList[9], arrivalMessageList[9], scanMessageList[9], exploreMessageList[9], 0, 0, false),
				new Planet(planetList[10], arrivalMessageList[10], scanMessageList[10], exploreMessageList[10], 1, 0, false),
				new Planet(planetList[11], arrivalMessageList[11], scanMessageList[11], exploreMessageList[11], 1, 3, false),
				new Planet(planetList[12], arrivalMessageList[12], scanMessageList[12], exploreMessageList[12], 2, 0, false),
				new Planet(planetList[13], arrivalMessageList[13], scanMessageList[13], exploreMessageList[13], 0, 0, false),
				new Planet(planetList[14], arrivalMessageList[14], scanMessageList[14], exploreMessageList[14], 0, 0, false),
				new Planet(planetList[15], arrivalMessageList[15], scanMessageList[15], exploreMessageList[15], 1, 0, false),
				new Planet(planetList[16], arrivalMessageList[16], scanMessageList[16], exploreMessageList[16], 1, 0, false),
				new Planet(planetList[17], arrivalMessageList[17], scanMessageList[17], exploreMessageList[17], 1, 0, false),
				new Planet(planetList[18], arrivalMessageList[18], scanMessageList[18], exploreMessageList[18], 0, 2, false),
				new Planet(planetList[19], arrivalMessageList[19], scanMessageList[19], exploreMessageList[19], 0, 0, false),
				new Planet(planetList[20], arrivalMessageList[20], scanMessageList[20], exploreMessageList[20], 0, 0, false),
				new Planet(planetList[21], arrivalMessageList[21], scanMessageList[21], exploreMessageList[21], 0, 0, false),
				new Planet(planetList[22], arrivalMessageList[22], scanMessageList[22], exploreMessageList[22], 0, 3, false),
				new Planet(planetList[23], arrivalMessageList[23], scanMessageList[23], exploreMessageList[23], 0, 0, false),
				new Planet(planetList[24], arrivalMessageList[24], scanMessageList[24], exploreMessageList[24], 0, 0, false),
				new Planet(planetList[25], arrivalMessageList[25], scanMessageList[25], exploreMessageList[25], 0, 2, false),
				new Planet(planetList[26], arrivalMessageList[26], scanMessageList[26], exploreMessageList[26], 0, 0, false),
				new Planet(planetList[27], arrivalMessageList[27], scanMessageList[27], exploreMessageList[27], 0, 0, false),
				new Planet(planetList[28], arrivalMessageList[28], scanMessageList[28], exploreMessageList[28], 0, 0, false),
				new Planet(planetList[29], arrivalMessageList[29], scanMessageList[29], exploreMessageList[29], 0, 0, false)
		);

	}

	public ArrayList<Planet> getPlanetArrayList() {
		return planetArrayList;
	}

	private String[] getPlanetList() {
		return new String[]{"WASP -12b", "Theta-10c", "Nore", "51 Pegasi b", "LV-426", "Shadowfax",
				"Lisus", "Insula", "Heralda", "Kepler-11f", "Nasqueron", "Altair IV", "TrES-2b",
				"55 Cancri e", "Gilese 436 b", "Rignus", "Helnetia", "Nitia", "Jor", "Jmea",
				"Atani Starship", "Drabenus", "Eos", "Zaria-3a", "Alpha08c", "Prion", "Planet Z",
				"Waldovo", "Genesis", "Gaia"};
	}

	private String[] getExploreMessageList() {
		return new String[]{"Cannot explore this planet",
				"The user finds vast tracks of sand. Located in the center of the northern most point of the planet is a" +
						" massive monument. On it, three massive statues: A boulder, a tablet, and a sheering device.",
				"Cannot explore this planet",
				"Cannot explore this planet",
				"A derelict engineer ship is found",
				"The player fumbles across the planet surface and en-counters 3 other-worldly portal doors towering at the base of a impassable incline.",
				"The ship sinks into the swamp and is unable to take flight. The swamp makes it difficult to navigate. After several hours of travel " +
						"you encounter a cave that appears to be occupied. The door blocking its entrance glows a faint blue and you see a small mallet " +
						"hanging by a rope from a dome-like protrusion on the door",
				"On the surface, partially buried by the sand, lies a body in an unfamiliar uniform. The body is clutching a metallic object in its hand, " +
						"that appears to be beeping ever so slightly.",
				"You scour the surface and find nothing particularly interesting or useful.",
				"We are being attacked by a group of dwellers",
				"50% chance to encounter nothing or an invisible monster",
				"You find nothing of interest or use",
				"You find nothing of interest or use",
				"You cannot explore this planet",
				"Your ship soon lands, and the animals scatter through the forest. When you set foot outside, you notice that the air around you has shifted," +
						" and a strange sound if coming your way. You turn your head towards the noise and see 3 creatures sprinting towards you.",
				"Upon landing, a huge aquatic serpent leaps over your ship and slaps its tail into your hull.",
				"A few hours of exploration reveal a tomb. Within it you find the skeletal remains of 3 ornate rulers. They are each roughly " +
						"as tall as the ship, but not quite as sturdy.",
				"You find nothing of interest or use.",
				"You cannot explore this planet.",
				"You cannot explore this planet.",
				"You find nothing of interest or use.",
				"You find nothing of interest or use.",
				"You cannot explore this planet.",
				"You find nothing of interest or use.",
				"You find nothing of interest or use.",
				"You’ve seen too many bad movies that start this way and think twice about exploring this planet.",
				"After days of searching you encounter a lone survivor. His unique red and white striped garb blends in surprisingly " +
						"well with the environment lending itself to his survival. He does not speak to you.",
				"While the humanoids are a sleep, you gathered up all the apples from the tree except one which had a note. " +
						"\"Do not eat this apple or listen to the snake. You will be banned from this garden and will suffer for all eternity.\" " +
						"You snicker and stash the note in your pack.",
				"A band of 5 adventurers meet you at the landing sight and explain, at length, their passion for rescuing the planet " +
						"and taking pollution down to zero. As you are leaving the planet a mysterious blue figure zips past your ship."
		};
	}

	private String[] getScanMessageList() {
		return new String[]{
				"Orbiting its star from a mere 2M miles, this metal-rich planet is the hottest ever recorded at a scorching 4k degrees F. Its chaotic surface " +
						"is liquid while facing the star and cools to a solid while facing away.",
				"The hot planet is a barren desert. It appears void of life and no electronic signals can be detected.",
				"Returns no useful data from the missing planet.",
				"Composed primarily of hydrogen and helium, this uninhabitable gas giant roasts in the light of its star at over 1800 degrees F. The player " +
						"detects a distress signal from an orbital research station that has suffered severe dam-age to its heat shield.",
				"This large moon is one of three orbiting a mid-sized gas giant with rings. A neighboring moon is now uninhabitable but appears to have " +
						"been home to an engineering facility at some point.",
				"This planet is pitch black, as though all light is being drawn in and captured by its surface. No useful data is gathered from the planet",
				"The earth-like planet has a rich biological ecosystem, teeming with life and resources. There are no signs of advanced civilizations.",
				"The silicone planet appears desolate with a wide expanse of sand and blistering winds.",
				"At roughly 2.5 times the mass of Earth, this “Super-Earth” has an atmosphere but much lower density. This has allowed a rich multitude of " +
						"avian-like creatures to flourish.",
				"A gas giant and home of the maddeningly unconcerned Dwellers, a non-humanoid species who lead an almost anarchic existence.",
				"This eerily silent, poorly lit planet drifts lifelessly through space 16 LY away from earth. The remains of a long forgotten civilization " +
						"suggest that they were destroyed seemingly overnight.",
				" Located approximately 750 LY from earth, this exoplanet may be the darkest in the galaxy, reflecting only 1% of the light that reaches it. " +
						"Beneath its shadowy atmosphere a dull red glow can be seen.",
				"At roughly twice the size of earth this carbon-rich planets core, nearly 80% of its mass, is composed entirely of diamond.",
				"The water planet has become solid ice as a result of an extraordinarily high gravity. Interestingly, the gravity responsible for compressing " +
						"water into ice also causes its icy surface to burn. Fiery columns float high above the horizon.",
				"Rignus appears to be a planet rich with wildlife. From above the skyscraper like trees, animals can be seen sprawled amongst the grassy fields.",
				"At first sight, Helnetia appears to be an orb of blue, and that is because the planet is a vast ocean of water, with few salt flats on its surface, " +
						"though they are hidden by water.",
				"Nitia, otherwise known as the skeleton planet. The only things here are bones and dust.",
				"The planet’s surface radiates an unbearable heat and a heavy mist of steam lines the atmosphere.",
				"Insane degrees of heath a pressure has turned this silicon planet into a solid sphere of glass.",
				"This planet was taken over entirely by the Atani Star Fleet. Its core has been excavated and its surface has been transformed into a massive " +
						"planet-sized station. Any attempt to navigate towards the structure is effortlessly rejected by tractor beams and warning lights.",
				"This over-sized, metal-rich asteroid is the only body or-biting the local star.",
				"This planet is roughly the size of Earth but its atmosphere is composed primarily of ammonia. The life forms ap-pear to have adapted well to this environment.",
				"This helium rich gas giant is several thousand light seconds from the local star. This causes the green house atmosphere to thrash violently with frozen shards of helium.",
				"This earth-like planet was once considered by our ancestors for interplanetary colonization. It has not yet formed any signs of life.",
				"This water-rich gas giant has a composition similar to earth. Its atmosphere features an impressive pallet of colorful clouds that stretch hundreds of miles into the sky.",
				"The planets rocky surface is home to a bipedal species that appears to wander the land in herds with only one purpose…to find and consume brain matter.",
				"This earth-like planets inhabitants are nowhere to be found though evidence of their presence remains. Beach towels on the coast, bags of popcorn scattered " +
						"across carnivals, and empty zoo cages rest quietly.",
				"This earth-like planet is the home of two unclothed humanoid beings frolicking in a garden near an apple tree. It seems that one is trying to communicate with a " +
						"snake while the other is chasing a lightening fast blue hedgehog.",
				"This earth-like planet is thick with smog emitted from its industrious inhabitants. They do not appear to have technology advanced enough to detect your presence."
		};
	}

	private String[] getArrivalMessageList() {
		return new String[]{"BOSS FIGHT! A wing of pirates ambushes from the shadow of the planet.",
				"BOSS FIGHT! A massive ship appears. The ALIEN WARRIORS is well armed and intends to harm the user. However, they offer to let the player live if they win " +
						"Paper, Rock, Scissor best 2 out of 3. If the user loses the game is over.",
				"BOSS FIGHT! The planet disappears from the ships contact list. The ship loses power and drifts slowly through space. Slowly, a mist envelopes the ship and " +
						"seeps through each deck. Then AMBER EYES, sharp as flames, appear before the ship within a gaseous body and unleash a bellowing roar.",
				"Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.",
				"Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.",
				"Nothing happens.", "The player is hailed and receives a message: You have entered restricted space. You will be escorted to the near-est warp entry point.",
				"Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens.", "Nothing happens."
		};
	}


}

