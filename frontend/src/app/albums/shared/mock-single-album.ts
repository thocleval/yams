import { Album } from './album';

export const MOCK_SINGLE_ALBUM: Album = {
  'id': '5915bc404de7b6ec23a188cf',
  'name': 'Booker',
  'coverPicture': 'https://unsplash.it/300/?random=10',
  'duration': 101,
  'tracks': [
    {
      id: '5915bc404de7b6ec23a188cf',
      name: 'Track 1',
      number: 1,
      duration: 89,
    },
    {
      id: '5915bc404de7a6ec23a188cf',
      name: 'Track 2',
      number: 2,
      duration: 130,
    },
    {
      id: '5915bct04de7b6ec23a188cf',
      name: 'Track 3',
      number: 3,
      duration: 45,
    },
    {
      id: '5915bc404de7b6ec23a188cf',
      name: 'Track 4',
      number: 4,
      duration: 4539,
    },
  ],
  'likeCount': 120,
  'artist': {
    'id': '59146247225c3ca77f8e868c',
    'name': 'David Guetta',
    'biography': 'Eiusmod adipisicing anim quis sint Lorem veniam anim laborum elit quis. Consequat deserunt' +
                 ' proident voluptate cillum adipisicing. Do aute ad laborum mollit. Ut elit et proident laborum id culpa dolor.',
    'likeCount': 30,
    'avatar': 'https://upload.wikimedia.org/wikipedia/commons/thumb/' +
                 '3/33/David_Guetta_2013-04-12_001.jpg/260px-David_Guetta_2013-04-12_001.jpg',
    'cover': 'https://www.hitradio.ma/media/uploads/actualites/9c0f4a02e5.jpg',
  },
  'styles': [
    {
      'id': '5915bc4094bdeab7694e7378',
      'name': 'non'
    }
  ]
};
