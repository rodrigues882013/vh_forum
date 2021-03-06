import {combineReducers} from 'redux';
import profile from './profileReducers';
import auth from './authReducer';
import topics from './topicsReducer';
import categories from './categoryReducer';
import comments from './commentReducers';



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
    topics,
    categories,
    comments
});

export default rootReducer;