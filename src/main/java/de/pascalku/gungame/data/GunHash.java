package de.pascalku.gungame.data;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Created by Pascal on 02.08.2017.
 */
@AllArgsConstructor
@Getter
public class GunHash {

    public GunHash() {
        inventoryStack = Maps.newHashMap();
    }

    private ItemStack head = null, chestPlate = null, leggings = null, boots = null;
    private Boolean clearInventory = false;

    private HashMap<Integer, ItemStack> inventoryStack;

    public void setToPlayer(Player target) {
        target.getInventory().setHelmet(head);
        target.getInventory().setChestplate(chestPlate);
        target.getInventory().setLeggings(leggings);
        target.getInventory().setBoots(boots);

        if(clearInventory) {
            for(int index = 0; index < target.getInventory().getSize(); index += 1) {
                target.getInventory().setItem(index, inventoryStack.getOrDefault(index, null));
            }
        } else {
            inventoryStack.forEach((key, value) -> target.getInventory().setItem(key, value));
        }
    }
}