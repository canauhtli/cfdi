package com.canauhtli.cfdi.pac;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ClienteFactory {
	
	public static ClienteServicioPAC getCliente(Map<String, String> config) throws ClientePACException {
        ClienteServicioPAC pac = null;
        String proveedor = config.get("servicio");
        try {
            Class<?> cfClass = Class.forName(proveedor);
            Constructor<?> constructor = cfClass.getConstructor(new Class[]{Map.class});
            pac = (ClienteServicioPAC) constructor.newInstance(config);
        }
        catch (InstantiationException e) {
            throw new ClientePACException("No fue posible crear una instancia del cliente del servicio", e);
        }
        catch (IllegalAccessException e) {
            throw new ClientePACException("No es posible acceder al cliente del servicio", e);
        }
        catch (ClassNotFoundException e) {
            throw new ClientePACException("Cliente del servicio no encontrado", e);
        }
        catch (SecurityException e) {
            throw new ClientePACException("Problema al crear cliente del servicio", e);
        }
        catch (NoSuchMethodException e) {
            throw new ClientePACException("Problema al crear cliente del servicio", e);
        }
        catch (IllegalArgumentException e) {
            throw new ClientePACException("Prolbema al crear cliente del servicio", e);
        }
        catch (InvocationTargetException e) {
            throw new ClientePACException("Problema al crear cliente del servicio", e);
        }
        return pac;
    }
}
