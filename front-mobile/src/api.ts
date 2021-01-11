import axios from "axios";

//const API_URL = 'http://192.168.0.116:8080';
const API_URL = 'https://jpideliver.herokuapp.com';

export function fetchOrders(){
    return axios(`${API_URL}/orders`);
}

export function confirmDelivery(orderId: number){
    return axios.put(`${API_URL}/orders/${orderId}/delivered`)
}