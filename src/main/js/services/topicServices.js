import axios from 'axios';

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _list(){
    return axios.get('http://localhost:8080/api/v1/topics');
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _get(id){
    return axios.get(`http://localhost:8080/api/v1/topics/${id}`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _create(topics){
    return axios.post(`http://localhost:8080/api/v1/topics`, topics);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _update(id, topics){
    return axios.put(`http://localhost:8080/api/v1/topics/${id}`, topics);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function _remove(id){
    return axios.delete(`http://localhost:8080/api/v1/topics/${id}`);
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export default {
    list: _list,
    get: _get,
    create: _create,
    update: _update,
    remove: _remove
};