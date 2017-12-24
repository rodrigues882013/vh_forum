
import types from '../actions/actionsTypes';
import initialState from './initialState';

function topicReducer(state = initialState.topic, action){

    let newState = state;

    switch(action.type) {
        case types.LOAD.TOPIC.SUCCESS:
            newState = action.topic;
            break;

        case types.LOAD.TOPICS.SUCCESS:
            newState = action.topics;
            break;

        case types.CREATE.TOPIC.SUCCESS:
            newState = action.topic;
            break;

        case types.UPDATE.TOPIC.SUCCESS:
            newState = action.topic;
            break;

        case types.CREATE.TOPIC.FAILED:
            newState = state;
            break;
    }

    return newState;
}

export default topicReducer;