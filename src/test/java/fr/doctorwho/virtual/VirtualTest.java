package fr.doctorwho.virtual;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;

import fr.doctorwho.utils.InventoryVirtual;
import fr.doctorwho.utils.ItemMenu;

public class VirtualTest extends InventoryVirtual{
	
	public VirtualTest() {
		super("Test", 3, Bukkit.getPlayer("Montras"));
	}

	@Override
	public Map<Integer, ItemMenu> registerItems() {
		Map<Integer, ItemMenu> items = new HashMap<>();
		items.put(15, new ItemTest());
		return items;
	}

}
