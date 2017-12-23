import {combineReducers} from 'redux';



import auth from './authReducer';


/**
 * Reducers are pure functions that receive actual state and return the new state
 *
 * Things you should never do inside a reducer:
 *  - Mutate its arguments;
 *  - Perform side effects like API calls and routing transitions;
 *  - Call non-pure functions, e.g. Date.now() or Math.random().
 */

const rootReducer = combineReducers({
    auth
});

export default rootReducer;