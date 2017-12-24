import {combineReducers} from 'redux';
import profile from './profileReducers';
import auth from './authReducer';
import topic from './topicReducer';


/**
 * Reducers are pure functions that receive actual state and return the new state
 *
 * Things you should never do inside a reducer:
 *  - Mutate its arguments;
 *  - Perform side effects like API calls and routing transitions;
 *  - Call non-pure functions, e.g. Date.now() or Math.random().
 */

const rootReducer = combineReducers({
    auth,
    profile,
    topic
});

export default rootReducer;