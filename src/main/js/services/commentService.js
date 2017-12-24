import axios from 'axios';

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _list(id){
    return axios.get(`http://localhost:8080/api/v1/topics/${id}/comments`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _get(id){
    return axios.get(`http://localhost:8080/api/v1/topics/${id}`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _create(id, comment){
    return axios.post(`http://localhost:8080/api/v1/topics/${id}/comments`, comment);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _update(topicId, id, comment){
    return axios.put(`http://localhost:8080/api/v1/topics/${topicId}/comments/${id}`, comment);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _remove(topicId, id){
    return axios.delete(`http://localhost:8080/api/v1/topics/${topicId}/comments/${id}`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


function _getCategories(){
    return axios.get(`http://localhost:8080/api/v1/categories`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


export default {
    list: _list,
    get: _get,
    create: _create,
    update: _update,
    remove: _remove,
    getCategories: _getCategories
};