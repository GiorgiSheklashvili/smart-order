package dev.lab.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class InventoryConfig {

    @Value("${inventory.threshold}")
    private int threshold;
}
