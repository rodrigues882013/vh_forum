
import types from '../actions/actionsTypes';
import initialState from './initialState';

export default function topicReducer(state = initialState.topics, action){

    let newState = state;

    switch(action.type) {

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

        default:
            return state;

    }

    return newState;
}
