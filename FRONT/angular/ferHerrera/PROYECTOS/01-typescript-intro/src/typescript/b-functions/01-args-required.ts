const fnFullNameee: (firstName: string, lastName: string) => string =
(firstName :string, lastName :string) :string => {
    return `${firstName} ${lastName}`;
}
console.log( fnFullNameee('Minnie','FC') );


const fnFullName = (firstName :string, lastName :string) :string => {
    return `${firstName} ${lastName}`;
}
const fullName = fnFullName('Shushi','FC');
console.log( {fullName} );