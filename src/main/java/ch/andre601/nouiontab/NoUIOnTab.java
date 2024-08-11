package ch.andre601.nouiontab;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientOnly
public class NoUIOnTab implements ModInitializer{
    public static final Logger LOGGER = LoggerFactory.getLogger("No UI on Tab");

	@Override
	public void onInitialize(ModContainer mod){
		LOGGER.info("Initializing Mod...");
	}
}
