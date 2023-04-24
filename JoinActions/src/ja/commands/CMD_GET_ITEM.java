package ja.commands;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_GET_ITEM
{
	
	@SuppressWarnings("deprecation")
	public static void GetItems(Player player)
	{
		ItemStack item = new ItemStack(267,1,(short) 0);
		ItemMeta attributes = item.getItemMeta();
		
		Enchantment enchantment = Enchantment.getByName("DAMAGE_ALL");
		
		attributes.addEnchant(enchantment, 10, true);
		
		item.setItemMeta(attributes);
		player.getInventory().addItem(item);
	}
	
}
