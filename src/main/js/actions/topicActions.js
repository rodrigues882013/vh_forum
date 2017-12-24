import topicsService from '../services/topicServices';
import types from './actionsTypes';


/*
 * Action creators
 */

export const loadTopicsSuccess = (topics) => ({type: types.LOAD.TOPICS.SUCCESS, topics});

export const loadTopicSuccess = (topics) => ({type: types.LOAD.TOPICS.SUCCESS, topics});

export const updateTopicSuccess = (topic)=> ({type: types.UPDATE.TOPIC.SUCCESS, topic});

export const createTopicSuccess = (topic) => ({type: types.CREATE.TOPIC.SUCCESS, topic});

// export const deleteTopicSuccess = (topic) => ({type: types.DELETE.TOPIC.SUCCESS, topic});

/*
* Actions
* */

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function loadTopic(id) {

    return function(dispatch){
        return topicService
            .get(id)
            .then( response => dispatch(loadTopicSuccess(response.data)))
            .catch( error => console.error(error));
    };

}
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function loadTopics() {

    return function(dispatch){
        return topicsService
            .list()
            .then( response =>{
                dispatch(loadTopicsSuccess(response.data));

            })
            .catch(error => console.error(error));
    };

}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

// export function deletetopic(id, history) {
//
//     return function(dispatch){
//         return topicsService
//             .remove(id)
//             .then( response =>{
//                 dispatch(deletetopicSuccess(response.data));
//                 history.push(`/topics`);
//             })
//             .catch(error => console.error(error));
//     };
//
// }

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function updateTopic(id, topic, history) {

    return function(dispatch){
        return topicsService
            .update(id, topic)
            .then( response =>{
                dispatch(updateTopicSuccess(response.data));
                history.push(`/topics`);
            })
            .catch(error => console.error(error));
    };

}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
export function createTopic(topic, history) {

    return function(dispatch){
        return topicsService
            .create(topic)
            .then( response => {
                dispatch(createTopicSuccess(response.data));
                history.push(`/topics`);

            })
            .catch(error => console.error(error));
    };

}
