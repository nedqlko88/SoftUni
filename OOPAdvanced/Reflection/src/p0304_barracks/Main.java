package p0304_barracks;

import p0304_barracks.contracts.Repository;
import p0304_barracks.contracts.UnitFactory;
import p0304_barracks.contracts.Runnable;
import p0304_barracks.core.Engine;
import p0304_barracks.core.factories.UnitFactoryImpl;
import p0304_barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
