package fr.doctorwho.virtual;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.doctorwho.utils.ItemMenu;

public class ItemTest extends ItemMenu {

	public ItemTest() {
		super(Material.ACACIA_DOOR, "test");
	}

	@Override
	public void use(Player player) {
		// lines codes
	}

}
