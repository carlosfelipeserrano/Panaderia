/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author carlo
 */
public class ClienteData {

        private static ClienteData instance = null;
        private int idCliente;

        private ClienteData() {
        }

        public static ClienteData getInstance() {
            if (instance == null) {
                instance = new ClienteData();
            }
            return instance;
        }

        public int getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(int idCliente) {
            this.idCliente = idCliente;
        }
    }
